/**
 * Copyright (c) 2016-2020, Mihai Emil Andronache
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 * Neither the name of the copyright holder nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */
package com.amihaiemil.eoyaml;

/**
 * Any Yaml line should have an even indentation (multiple of 2).
 * @deprecated Usage of this class has been removed since the assumption
 *  that any YAML line should have an even indentation is incorrect. It
 *  will probably be removed later.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 1.0.0
 *
 */
@Deprecated
final class EvenlyIndentedLine implements YamlLine {

    /**
     * Original line.
     */
    private YamlLine line;

    /**
     * Ctor.
     * @param line Original YamlLine
     */
    EvenlyIndentedLine(final YamlLine line) {
        this.line = line;
    }

    @Override
    public String trimmed() {
        return this.line.trimmed();
    }

    @Override
    public int number() {
        return this.line.number();
    }

    @Override
    public int indentation() {
        final int indentation = this.line.indentation();
        if (indentation % 2 != 0) {
            throw new IllegalStateException(
                "Indentation of line " + this.line.number() + " is incorrect. "
                + "It is " + indentation + " and it should be a multiple of 2!"
            );
        }
        return indentation;
    }

    @Override
    public String toString() {
        return this.line.toString();
    }

    @Override
    public int compareTo(final YamlLine other) {
        return this.line.compareTo(other);
    }

    @Override
    public boolean hasNestedNode() {
        return this.line.hasNestedNode();
    }
}
