/*
 * MIT License
 *
 * Copyright (c) 2024 Kent010341
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.example.DynamicBeanInjectionPoc.object;

import com.example.DynamicBeanInjectionPoc.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Represents a Foo object that requires a BarService to perform operations.
 * It uses a static factory method to enforce dependency injection.
 *
 * @author Kent010341
 */
public class Foo {

    private final String name;
    private final BarService barService;

    private Foo(String name, BarService barService) {
        this.name = name;
        this.barService = barService;
    }

    /**
     * Calls the addInfo method of BarService.
     *
     * @return the result from BarService
     */
    public String addInfoWithService() {
        return barService.addInfo(name);
    }

    /**
     * Factory for creating instances of {@link Foo}.
     */
    @Component
    public static class FooFactory {

        @Autowired
        private BarService barService;

        /**
         * Creates an instance of {@link Foo}.
         *
         * @param name the name to be used by Foo
         * @return an instance of Foo
         */
        public Foo createFoo(String name) {
            return new Foo(name, barService);
        }
    }
}
