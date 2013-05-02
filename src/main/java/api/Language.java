/**
 * Context-Free-Grammar to Push-down Automaton Converter
 * Copyright (C) 2012  Vy  Nguyen
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

package api;

/**
 *
 * @author vnguyen
 */
public interface Language
{
 
    /**
     * 
     * @return a string of the language 
     */
    String sampleString();
    
    /**
     * 
     * @return a machine that recognizes the language 
     */
    Machine getMachine();
    
    /**
     * 
     * @return a machine that generates the language 
     */
    Machine getGenerator();
    
    /** 
     * 
     * @param str
     * @return true if string str is part of the language. False otherwise
     */
    boolean isValidString(String str);
}
