/**
 * Context-Free-Grammar to Push-down Automaton Converter
 * Copyright (C) 2012  Vy Nguyen
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

package parser;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import unparser.Unparser;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Comparator;
import java.io.File;
import cfgpda.Cfg;
import java.util.logging.Level;
import java.util.logging.Logger;
import parser.ParseException;
import java.io.StringReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author vnguyen
 */
public class ParseUnparseTest
{
    private static final File PATH
            = new File("src/test/resources/unparse");

    @Test
    public void testFromSource() throws ParseException
    {
        File[] files = PATH.listFiles();
        Arrays.sort(files,
                    new Comparator<File>()
                    {
                        @Override
                        public int compare(File t, File t1)
                        {
                            return t.getName().compareTo(t1.getName());
                        }
                    });


        FileInputStream fis;
        Scanner in;
        Scanner expected;

        for (int n = 0; n < files.length; n += 2)
        {
            try
            {
                in = new Scanner(fis = new FileInputStream(files[n+1]));
                expected = new Scanner(files[n]);

                CFGGrammar parser = new CFGGrammar(fis);
                Cfg cfg = parser.start();

                // check unparse
                Set<String> actualRules = Unparser.unparse(cfg);
                Set<String> expectedRules = new HashSet<String>();
                while (expected.hasNextLine())
                    expectedRules.add(expected.nextLine().trim());
                expectedRules.remove("");

                assertEquals(expectedRules, actualRules);
            }
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(ParseUnparseTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    @Test
    public void testSimple() throws ParseException
    {
        doTest("D => Ba \nB=>c \nD=>x", 'D');
    }

    @Test
    public void testMultipleProductions() throws ParseException
    {
        doTest("A => aa | AB | Ab | e", 'A');
    }

    @Test(expected=ParseException.class) // Only a 'variable' can be on the LHS
    public void testWrongVariable() throws ParseException
    {
        doTest("Aa => aa | AB | Ab", '0');
    }

    @Test(expected=ParseException.class) // Only a 'variable' can be on the LHS
    public void testTerminalOnTheLeft() throws ParseException
    {
        doTest("b => aa | AB | Ab", '0');
    }

    private static void doTest(String in, char s) throws ParseException
    {
        CFGGrammar parser = new CFGGrammar(new BufferedReader(new StringReader(in)));
        Cfg cfg = parser.start();

        assertEquals("Start variable: ", s, cfg.getStartVar());
    }
}