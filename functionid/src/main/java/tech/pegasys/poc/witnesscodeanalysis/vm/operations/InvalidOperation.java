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
import tech.pegasys.poc.witnesscodeanalysis.vm.ExceptionalHaltReason;

import tech.pegasys.poc.witnesscodeanalysis.vm.MessageFrame;

public class InvalidOperation extends AbstractOperation {
  public static final int OPCODE = 0xFE;

  public InvalidOperation() {
    super(OPCODE, "INVALID", -1, -1, 1);
  }

  @Override
  public void execute(final MessageFrame frame) {
    frame.setState(MessageFrame.State.EXCEPTIONAL_HALT);
    frame.getExceptionalHaltReasons().add(ExceptionalHaltReason.INVALID_OPERATION);
  }
}
