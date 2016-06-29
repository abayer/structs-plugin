/*
 * The MIT License
 *
 * Copyright 2016 CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins.structs.describable;

import org.jenkinsci.plugins.structs.Fishing;
import org.jenkinsci.plugins.structs.FishingNet;
import org.jenkinsci.plugins.structs.Internet;
import org.jenkinsci.plugins.structs.Tech;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import static org.junit.Assert.assertEquals;

/**
 * @author Kohsuke Kawaguchi
 */
public class DescribableModelWithJenkinsTest {
    @Rule
    public JenkinsRule rule = new JenkinsRule();

    /**
     * Makes sure resolveClass can do both symbol & class name lookup
     */
    @Test
    public void resolveClass() throws Exception {
        assertEquals(FishingNet.class, DescribableModel.resolveClass(Fishing.class, null, "net"));
        assertEquals(FishingNet.class, DescribableModel.resolveClass(Fishing.class, "FishingNet", null));
        assertEquals(Internet.class, DescribableModel.resolveClass(Tech.class, null, "net"));
        assertEquals(Internet.class, DescribableModel.resolveClass(Tech.class, "Internet", null));
    }
}