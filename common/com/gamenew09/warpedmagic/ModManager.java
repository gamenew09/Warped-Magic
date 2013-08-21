package com.gamenew09.warpedmagic;

import java.util.ArrayList;

import com.google.common.base.Strings;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;

public class ModManager {
	
	private static ModManager instance;
	
	public static ModManager getInstance(){
		if(instance == null){
			instance = new ModManager();
		}
		return instance;
	}
	
	private ArrayList<ModContainer> mods = new ArrayList<ModContainer>();
	
	private ModManager(){
		for (ModContainer mod : Loader.instance().getModList()) {
            if (mod.getMetadata()!=null && mod.getMetadata().parentMod==null && !Strings.isNullOrEmpty(mod.getMetadata().parent)) {
                String parentMod = mod.getMetadata().parent;
                ModContainer parentContainer = Loader.instance().getIndexedModList().get(parentMod);
                if (parentContainer != null)
                {
                    mod.getMetadata().parentMod = parentContainer;
                    parentContainer.getMetadata().childMods.add(mod);
                    continue;
                }
            }
            else if (mod.getMetadata()!=null && mod.getMetadata().parentMod!=null)
            {
            	 continue;
            }
            System.out.println("("+mod.getModId()+") " + mod.getName() + " " +mod.getVersion());
            mods.add(mod);
        }
	}
	
	public void reloadList(){
		mods.clear();
		for (ModContainer mod : Loader.instance().getModList()) {
            if (mod.getMetadata()!=null && mod.getMetadata().parentMod==null && !Strings.isNullOrEmpty(mod.getMetadata().parent)) {
                String parentMod = mod.getMetadata().parent;
                ModContainer parentContainer = Loader.instance().getIndexedModList().get(parentMod);
                if (parentContainer != null)
                {
                    mod.getMetadata().parentMod = parentContainer;
                    parentContainer.getMetadata().childMods.add(mod);
                    continue;
                }
            }
            else if (mod.getMetadata()!=null && mod.getMetadata().parentMod!=null)
            {
            	 continue;
            }
            System.out.println("("+mod.getModId()+") " + mod.getName() + " " +mod.getVersion());
            mods.add(mod);
        }
	}
	
	public boolean isModInstalled(String modId){
		for(ModContainer mod : mods){
			if(mod.getModId().toLowerCase() == modId.toLowerCase()){
				WarpedMagicMod.log.info("t2354");
				return true;
			}
		}
		return false;
	}
	
}
