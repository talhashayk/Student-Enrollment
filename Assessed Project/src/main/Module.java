package main;
/**
 * @author Talha Sheikh
 * @version 1.0
 * @since 08-05-2018
 * Student Number: 170322690
 */

/**
 * the module class is used in order to create instances of modules that
 * are passed into the @modules HashMap. They are passed in via an object
 * factory and are thus ensured to be unique.
 */

import java.util.HashMap;
import java.util.Map;

public final class Module {

	private String moduleCode = "";
	private String moduleName = "";
	private int moduleCredits = 0;
	private static Map<String, Module> modules = new HashMap<String, Module>();

	public Module() {
	}

	public Module(String moduleCode, String moduleName, int moduleCredits) {
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.moduleCredits = moduleCredits;
	}

	public static Module getInstance(String moduleCode, String moduleName, int moduleCredits) {
		final String k = (moduleCode + moduleName);
		if (!modules.containsKey(k)) {
			modules.put(k, new Module(moduleCode, moduleName, moduleCredits));
		}
		return modules.get(k);
	}

	public static Map<String, Module> getMODULES() {
		return modules;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public String getModuleName() {
		return moduleName;
	}

	public int getModuleCredits() {
		return moduleCredits;
	}

	public String toString() {
		return new String(moduleCode + ":\t" + moduleName + ": " + moduleCredits + "\n");
	}
	
}
