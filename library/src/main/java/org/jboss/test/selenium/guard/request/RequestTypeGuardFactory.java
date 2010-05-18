/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.test.selenium.guard.request;

import org.jboss.test.selenium.framework.AjaxSelenium;

/**
 * The factory for shortening use of {@link RequestTypeGuard}s in code.
 * 
 * @author <a href="mailto:lfryc@redhat.com">Lukas Fryc</a>
 * @version $Revision$
 */
public final class RequestTypeGuardFactory {

    private RequestTypeGuardFactory() {
    }

    /**
     * Shortcut for registering a XMLHttpRequest on given selenium object.
     * 
     * @param selenium
     *            where should be registered XMLHttpRequest guard
     * @return the selenium guarded to use XMLHttpRequest
     */
    public static AjaxSelenium guardXhr(AjaxSelenium selenium) {
        AjaxSelenium copy = selenium.immutableCopy();
        copy.registerGuard(new XMLHttpRequestGuard());
        return copy;
    }

    /**
     * Shortcut for registering a regular HTTP request on given selenium object.
     * 
     * @param selenium
     *            where should be registered regular HTTP request guard
     * @return the selenium guarded to use regular HTTP requests
     */
    public static AjaxSelenium guardHttp(AjaxSelenium selenium) {
        AjaxSelenium copy = selenium.immutableCopy();
        copy.registerGuard(new RegularHttpRequestGuard());
        return copy;
    }

    /**
     * Shortcut for registering a guard for no request on given selenium object.
     * 
     * @param selenium
     *            where should be registered no request guard
     * @return the selenium guarded to use no request during interaction
     */
    public static AjaxSelenium guardNoRequest(AjaxSelenium selenium) {
        AjaxSelenium copy = selenium.immutableCopy();
        copy.registerGuard(new NoRequestGuard());
        return copy;
    }
}