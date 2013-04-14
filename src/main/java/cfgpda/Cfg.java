/**
 * Context-Free-Grammar to Push-down Automaton Converter
 * Copyright (C) 2012  Vy Thuy Nguyen
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
 * Boston, MA  02110-1301, USA.
 */
package cfgpda;

import api.Generator;
import api.Machine;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author vythuynguyen
 */
public class Cfg implements Generator
{
    public static final String EPSILON = "e";
    
    private final Set<Character> variables;
    private final Set<Character> terminals;
    private final Map<Character, Set<String>> rules;
    private final char startVar;
    private final int rulesCount;
    public Cfg(char startVar, Map<Character, Set<String>> rules)
    {
        this.variables = rules.keySet();
        this.terminals = findTerminals(rules);
        this.rules = rules;
        this.startVar = startVar;

        int c = 0;
        for (Set<String> strings : rules.values())
            c += strings.size();
        rulesCount = c;
    }
    
    @Override
    public String toString()
    {
        // TODO
        return rules.toString();
    }
    
    @Override
    public boolean isValidString(String str)
    {
        for (int i = 0; i < str.length(); ++i)
            if (!this.terminals.contains(str.charAt(i)))
                return false;
        
        return true;
    }
    
    public Map<Character, Set<String>> getRules()
    {
        return Collections.unmodifiableMap(rules);
    }
    
    public Set<Character> getVariables()
    {
        return Collections.unmodifiableSet(variables);
    }
    
    public Set<Character> getTerminals()
    {
        return Collections.unmodifiableSet(terminals);
    }
    
    public int rulesCount()
    {
        return rulesCount;
    }
    
    public char getStartVar()
    {
        return startVar;
    }
    
    private static Set<Character> findTerminals(Map<Character, Set<String>> rules)
    {
        // TODO
        return null;
    }
}
