/**
 * Copyright (C) 2013 Luca Prete, Andrea Biancini, Fabio Farina - www.garr.it - Consortium GARR
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Implementation of the Floodlight GreenMST service.
 * 
 * @author Luca Prete <luca.prete@garr.it>
 * @author Andrea Biancini <andrea.biancini@garr.it>
 * @author Fabio Farina <fabio.farina@garr.it>
 * 
 * @version 0.90
 * @see it.garr.greenmst.GreenMST
 * @see it.garr.greenmst.IGreenMSTService
 * @see it.garr.greenmst.TopologyCostsLoader
 * @see it.garr.greenmst.algorithms.IMinimumSpanningTreeAlgorithm
 * @see it.garr.greenmst.algorithms.KruskalAlgorithm
 * @see it.garr.greenmst.types.LinkWithCost
 * @see it.garr.greenmst.types.TopologyCosts
 * @see it.garr.greenmst.web.GreenMSTWebRoutable
 * @see it.garr.greenmst.web.MSTEdgesResource
 * @see it.garr.greenmst.web.RedundantEdgesResource
 * @see it.garr.greenmst.web.TopoCostsResource
 * @see it.garr.greenmst.web.TopoEdgesResource
 * @see it.garr.greenmst.web.serializers.LinkWithCostJSONSerializer
 * @see it.garr.greenmst.web.serializers.TopologyCostsJSONDeserializer
 * @see it.garr.greenmst.web.serializers.TopologyCostsJSONSerializer
 * 
 */

package it.garr.greenmst.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class GreenMSTTestRunner {
	
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(GreenMSTTestSuite.class);
      
      for (Failure failure : result.getFailures()) {
         System.err.println(failure.toString());
      }
      
      System.out.println(result.wasSuccessful());
   }

}  	