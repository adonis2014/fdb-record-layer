/*
 * NonAsyncIterator.java
 *
 * This source file is part of the FoundationDB open source project
 *
 * Copyright 2015-2018 Apple Inc. and the FoundationDB project authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.apple.foundationdb.async;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;

/**
 * An {@link AsyncIterator} that just wraps an ordinary {@link Iterator}.
 * @param <T> type of iterator elements
 */
public class NonAsyncIterator<T> implements AsyncIterator<T> {
    @Nonnull private Iterator<T> underlying;

    public NonAsyncIterator(@Nonnull Iterator<T> underlying) {
        this.underlying = underlying;
    }

    @Override
    public CompletableFuture<Boolean> onHasNext() {
        return CompletableFuture.completedFuture(hasNext());
    }

    @Override
    public boolean hasNext() {
        return underlying.hasNext();
    }

    @Override
    public T next() {
        return underlying.next();
    }

    @Override
    public void cancel() {
    }
}
