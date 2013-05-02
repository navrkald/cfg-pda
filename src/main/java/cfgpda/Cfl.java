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
package cfgpda;

import api.Language;
import api.Machine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author vnguyen
 */
public class Cfl implements Language 
{
    private Cfg cfg;
    
    public Cfl(Cfg cfg)
    {
        this.cfg = cfg;
    }
    
    @Override
    public String sampleString()
    {
        return "test";
    }
    
    @Override
    public Pda getMachine()
    {
        return new Pda(this);
    }
    
    @Override
    public boolean isValidString(String str)
    {
        return cfg.isValidString(str);
    }
    
    @Override
    public Machine getGenerator()
    {
        return this.cfg;
    }
    
    public Cfl toChomskyNormalForm()
    {
        throw new NotImplementedException();
    }
    
    
    
}
