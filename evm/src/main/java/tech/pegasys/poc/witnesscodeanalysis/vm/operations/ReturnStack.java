/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package tech.pegasys.poc.witnesscodeanalysis.vm.operations;

import static com.google.common.base.Preconditions.checkState;

import java.util.ArrayDeque;

/**
 * This class describes the behaviour of the Return stack introduce on the
 * https://eips.ethereum.org/EIPS/eip-2315
 */
public class ReturnStack extends ArrayDeque<Integer> {

  private final int capacity;

  public ReturnStack(final int numElements) {
    super(numElements);
    this.capacity = numElements;
  }

  public boolean isFull() {
    return this.size() >= capacity;
  }

  @Override
  public Integer pop() {
    try {
      return super.pop();
    } catch (Exception e) {
      throw new IllegalStateException("return stack underflow");
    }
  }

  @Override
  public void push(final Integer value) {
    checkState(!isFull(), "return stack overflow");
    super.push(value);
  }
}
