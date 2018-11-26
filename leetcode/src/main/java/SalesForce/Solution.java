package SalesForce;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import static java.util.stream.Collectors.toSet;

class Module {
    protected static Map<String, Module> dependencyMap = new LinkedHashMap<String, Module>();

    private String name;
    private Set<Module> dependencies = new LinkedHashSet<Module>();
    private Set<Module> dependents = new LinkedHashSet<Module>();
    private Set<Module> installedList= new LinkedHashSet<Module>();
    private boolean installed;

    private Module(String name) {
        this.name = name;
    }



    public static Module getInstance(String name) {
        Module target = dependencyMap.get(name);
        if (target == null) {
            target = new Module(name);
            dependencyMap.put(name, target);
        }
        return target;
    }

    public String getName() {
        return name;
    }

    public boolean isInstalled() {
        return installed;
    }

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }

    public Set<Module> getDependents() {
        return dependents;
    }

    public boolean hasDependents() {
        return !dependents.isEmpty();
    }

    public boolean hasDependencies() {
        return !dependencies.isEmpty();
    }

    public Set<Module> getDependencies() {
        return dependencies;
    }

    public boolean addDependency(Module d) {
        return dependencies.add(d);
    }

    public static boolean addInstalled(Module d) {
        return installedList.add(d);
    }

    public boolean addDependent(Module d) {
        return dependents.add(d);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Module that = (Module) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }


    public static Collection<Module> getAll() {
        return dependencyMap.values();
    }

    public static Set<Module> getInstalled() {
        Set<Module> installed = new LinkedHashSet<Module>();
        for (Module module : dependencyMap.values()) {
            if (module.isInstalled())
                installed.add(module);
        }
        return installed;
    }
}
interface Command
{
    Map<String, Object> execute(List<String> args);
}

class DependCommand implements Command
{
    @Override
    public Map<String, Object> execute(List<String> args) {
        String depName = args.get(0);

        Module current = Module.getInstance(depName);

        for (String strDependency : args.subList(1, args.size())) {
            Module dependency = Module.getInstance(strDependency);
            current.addDependency(dependency);
            dependency.addDependent(current);
        }
        return Collections.emptyMap();
    }
}

 class InstallCommand implements Command {

    @Override
    public Map<String, Object> execute(List<String> args) {
        Map<String, Object> result = new LinkedHashMap<>();
        for (String depName : args) {

            Module dep = Module.getInstance(depName);
            Module.
            install(dep, result);
        }
        return result;
    }

    private Map<String, Object> install(Module current, Map<String, Object> result) {
        if (!current.isInstalled()) {
            current.setInstalled(true);


            for (Module dependency : current.getDependencies()) {
                if (!dependency.isInstalled()) { // not entirely necessary
                    install(dependency, result);
                }

            }
            result.put(current.getName(), "Installing");

        } else {
            result.put(current.getName(), "is already installed");

        }
        return result;
    }

}

 class ListCommand implements Command {


    @Override
    public Map<String, Object> execute(List<String> args) {
        Map<String, Object> result = new LinkedHashMap<>();
        Module.getInstalled().forEach(m -> result.put(m.getName(),""));
        return result;
    }

}

class RemoveCommand implements Command {

    @Override
    public Map<String, Object> execute(List<String> args) {
        Module d = Module.getInstance(args.get(0));
        if(d != null)
            return uninstall(d);
        Map<String,Object> result = new LinkedHashMap<>();
        result.put(args.get(0),"is not installed");
        return result;
    }

    private Map<String, Object> uninstall(Module parent) {
        Map<String, Object> result = new HashMap<>();
        Set<Module> installedDependents = parent.getDependents().stream().filter(Module::isInstalled).collect(toSet());
        if(installedDependents.isEmpty()) {
            result.put(parent.getName(),"successfully removed");
            parent.setInstalled(false);

            for (Module dependency : parent.getDependencies()) {
                if(dependency.isInstalled()) {
                    result.putAll(uninstall(dependency));
                }
            }
        }
        else {

            result.put(parent.getName(),"is still needed.");
        }
        return result;
    }
}

public class Solution {


    private static Map<String, Command> COMMANDS = new HashMap<>();


    // add all commands
    static
    {

        COMMANDS.put("DEPEND", new DependCommand());
        COMMANDS.put("INSTALL", new InstallCommand());
        COMMANDS.put("REMOVE", new RemoveCommand());
        COMMANDS.put("LIST", new ListCommand());
    }

    static void doIt(String[] input) {

        for(String line : input)
        {
            if(line != null && line.length() > 0)
            {
                if(line.equals("END"))
                {
                    System.out.println(line);
                    break;
                }
                else
                {
                    processLine(line);
                }
            }
        }

    }

    private static void processLine(String line)
    {
        String[] arguments = line.split("\\s+");
        Command cmd = COMMANDS.get(arguments[0]);
        // if any illeagal command is present, throw exception
        if (cmd == null)
        {
            throw new IllegalArgumentException("Unknown Command" + line);
        }

        List<String> args = new LinkedList<>(Arrays.asList(arguments));
        args.remove(0);
        Map<String, Object> success = cmd.execute(args);
        System.out.println(line);


        for(Map.Entry m:success .entrySet()){
           if(m.getValue().toString().length() == 0 )
           {
               System.out.println(  m.getKey()  );
           }
           else
           {
               System.out.println( m.getValue()+ " " + m.getKey() );
           }
        }

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        doIt(_input);

    }
}
