/*
 * Copyright 2019 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
pragma solidity >=0.4.23;

// One function calling another function in the same contract.
contract Simple5 {
    address public owner;
    uint256 public val1;

    function set1(uint256 _val) external {
        require(msg.sender == owner);
        set2(_val);
    }

    function set2(uint256 _val) public {
        require(msg.sender == owner);
        set3(_val + 2);
    }

    function set3(uint256 _val) private {
        val1 = _val + 3;
    }

}