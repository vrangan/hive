/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.parse;

import org.apache.hadoop.hive.ql.QueryState;

/**
 * ExportEventsSemanticAnalyzer is a successor to ExportSemanticAnalyzer intended
 * for use by the Replication subsystem.
 *
 * It is triggered by syntax that looks like this:
 *
 * EXPORT EVENT event_id1[-event_id2] TO path
 *
 * And this results in performing an export for replication for either a singular
 * event_id1 or a range event_id1 to event_id2 if a range is specified, to a path
 * as specified.
 *
 * We have a couple of important goals for this:
 *
 * a) Keep ExportEventsSemanticAnalyzer cleaner than the mess that is the current
 *    ExportSemanticAnalyzer, or at least better-architected and documented so that
 *    it is easier to read and understand.
 * b) When exporting a bunch of events in one shot, the directory to which we are
 *    exporting should be appendable-to/ammendable by future runs of EXPORT EVENT.
 * c) We should support Event-collapsing, in a pluggable fashion if possible
 * d) It is highly likely that we will be dealing with a ton of data that comes
 *    through this, and thus, we should do our very best to be memory conscious.
 */
public class ExportEventsSemanticAnalyzer extends BaseSemanticAnalyzer {

  private ReplicationSpec replicationSpec;

  public ExportEventsSemanticAnalyzer(QueryState queryState) throws SemanticException {
    super(queryState);
  }

  @Override
  public void analyzeInternal(ASTNode ast) throws SemanticException {

  }
}
