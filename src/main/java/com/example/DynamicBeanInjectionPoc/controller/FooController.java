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
package com.example.DynamicBeanInjectionPoc.controller;

import com.example.DynamicBeanInjectionPoc.object.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling Foo-related requests.
 *
 * @author Kent010341
 */
@RestController
@RequestMapping("/api")
public class FooController {

    @Autowired
    private Foo.FooFactory fooFactory;

    /**
     * Handles GET requests to create and use a Foo instance.
     *
     * @param name the name to be used by Foo
     * @return the result from Foo's service
     */
    @GetMapping("/foo")
    public ResponseEntity<String> getFoo(@RequestParam String name) {
        Foo foo = fooFactory.createFoo(name);
        String output = foo.addInfoWithService();
        return ResponseEntity.ok(output);
    }
}
