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


import tech.pegasys.poc.witnesscodeanalysis.vm.AbstractOperation;

import tech.pegasys.poc.witnesscodeanalysis.vm.MessageFrame;

import java.math.BigInteger;

import org.apache.tuweni.bytes.Bytes32;
import org.apache.tuweni.units.bigints.UInt256;

public class SGtOperation extends AbstractOperation {

  public SGtOperation() {
    super(0x13, "SGT", 2, 1, 1);
  }

  @Override
  public UInt256 execute(final MessageFrame frame) {
    final Bytes32 value0 = frame.popStackItem();
    final Bytes32 value1 = frame.popStackItem();

    BigInteger b0 = value0.toBigInteger();
    BigInteger b1 = value1.toBigInteger();

    final Bytes32 result = b0.compareTo(b1) > 0 ? UInt256.ONE.toBytes() : UInt256.ZERO.toBytes();

    frame.pushStackItem(result);

    return UInt256.ZERO;
  }
}