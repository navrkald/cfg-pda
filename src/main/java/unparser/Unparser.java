

package unparser;

import cfgpda.Cfg;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Unparser
{
    public static Set<String> unparse(Cfg cfg)
    {
        Set<String> ret = new HashSet<String>();
        Map<Character, Set<String>> rules = cfg.getRules();
        
        for (Character var : rules.keySet())
        {
            for (String target : rules.get(var))
                ret.add(String.format("%c => %s", var, target));
        }
        return ret;
    }
}
