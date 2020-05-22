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

import org.apache.tuweni.bytes.Bytes32;
import org.apache.tuweni.units.bigints.UInt256;

public class ShrOperation extends AbstractOperation {

  public ShrOperation() {
    super(0x1c, "SHR", 2, 1, 1);
  }

  @Override
  public UInt256 execute(final MessageFrame frame) {
    final UInt256 shiftAmount = UInt256.fromBytes(frame.popStackItem());
    final Bytes32 value = frame.popStackItem();

    if (!shiftAmount.fitsInt() || shiftAmount.intValue() >= 256) {
      frame.pushStackItem(Bytes32.ZERO);
    } else {
      frame.pushStackItem(value.shiftRight(shiftAmount.intValue()));
    }
    return UInt256.ZERO;
  }
}