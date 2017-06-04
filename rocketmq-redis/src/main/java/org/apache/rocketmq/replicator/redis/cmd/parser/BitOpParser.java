/*
 *
 *   Copyright 2016 leon chen
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  modified:
 *    1. rename package from com.moilioncircle.redis.replicator to
 *        org.apache.rocketmq.replicator.redis
 *
 */

package org.apache.rocketmq.replicator.redis.cmd.parser;

import org.apache.rocketmq.replicator.redis.cmd.CommandParser;
import org.apache.rocketmq.replicator.redis.cmd.impl.BitOpCommand;
import org.apache.rocketmq.replicator.redis.cmd.impl.Op;

/**
 * @author Leon Chen
 * @since 2.1.0
 */
public class BitOpParser implements CommandParser<BitOpCommand> {
    @Override
    public BitOpCommand parse(Object[] command) {
        int idx = 1;
        String strOp = (String) command[idx++];
        Op op = Op.valueOf(strOp.toUpperCase());
        String destKey = (String) command[idx++];
        String[] keys = new String[command.length - 3];
        for (int i = idx, j = 0; i < command.length; i++, j++) {
            keys[j] = (String) command[i];
        }
        return new BitOpCommand(op, destKey, keys);
    }

}