/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.mllp;

/**
 * Raised when a MLLP Producer or consumer encounters a corrupt MLLP Frame while attempting
 * to read or write a MLLP payload.
 */
public class MllpFrameException extends MllpException {
    private final byte[] mllpPayload;

    public MllpFrameException(String message, byte[] mllpPayload) {
        super(message);
        this.mllpPayload = mllpPayload;
    }

    public MllpFrameException(String message, byte[] mllpPayload, Throwable cause) {
        super(message, cause);
        this.mllpPayload = mllpPayload;
    }

    public byte[] getMllpPayload() {
        return mllpPayload;
    }

    @Override
    public String getMessage() {
        if (isLogPhi()) {
            return String.format("%s:\n\tMLLP Payload: %s", super.getMessage(), covertBytesToPrintFriendlyString(mllpPayload));
        } else {
            return super.getMessage();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getName());

        stringBuilder.append(": {mllpPayload=")
                .append(covertBytesToPrintFriendlyString(mllpPayload))
                .append("}");

        return stringBuilder.toString();
    }

}
