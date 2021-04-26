/* 
 * The MIT License
 *
 * Copyright 2019 Mani Moayedi (acidmanic.moayedi@gmail.com).
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
package com.acidmanic.lightweight.logger;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class ArchiveLogger implements Logger {

    private final List<LogItem> records;
    private int warnings;
    private int errors;

    public ArchiveLogger() {

        this.records = new ArrayList<>();

        clear();
    }

    @Override
    public void log(String message) {

        this.records.add(new LogItem(message, LogTypes.LOG));
    }

    @Override
    public void info(String message) {

        this.records.add(new LogItem(message, LogTypes.LOG));
    }

    @Override
    public void warning(String message) {

        this.warnings += 1;

        this.records.add(new LogItem(message, LogTypes.WARNING));
    }

    @Override
    public void error(String message) {

        this.errors += 1;

        this.records.add(new LogItem(message, LogTypes.ERROR));
    }

    public List<LogItem> getRecords() {

        ArrayList<LogItem> ret = new ArrayList<>();

        ret.addAll(this.records);

        return ret;
    }

    public final void clear() {
        this.errors = 0;
        this.warnings = 0;
        this.records.clear();
    }

    public ResultTypes getOverallSuccess() {

        if (this.errors > 0) {

            return ResultTypes.Failed;
        }
        if (this.warnings > 0) {

            return ResultTypes.PassedWithWarnings;
        }
        return ResultTypes.FlawlessSuccess;
    }
}
