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
 * Class that serializes the ComparableLink type of the GreenMST service.
 * 
 * @author Luca Prete <luca.prete@garr.it>
 * @author Andrea Biancini <andrea.biancini@garr.it>
 * @author Fabio Farina <fabio.farina@garr.it>
 * 
 * @version 0.90
 * @see it.garr.greenmst.GreenMST
 * @see it.garr.greenmst.TopologyCostsLoader
 * @see it.garr.greenmst.algorithms.IMinimumSpanningTreeAlgorithm
 * @see it.garr.greenmst.algorithms.KruskalAlgorithm
 * @see it.garr.greenmst.IGreenMSTService
 * @see it.garr.greenmst.types.TopologyCosts
 * @see it.garr.greenmst.types.LinkWithCost
 * @see it.garr.greenmst.web.GreenMSTWebRoutable
 * @see it.garr.greenmst.web.MSTEdgesResource
 * @see it.garr.greenmst.web.RedundantEdgesResource
 * @see it.garr.greenmst.web.TopoCostsResource
 * @see it.garr.greenmst.web.TopoEdgesResource
 * @see it.garr.greenmst.web.serializers.LinkWithCostJSONSerializer
 * @see it.garr.greenmst.web.serializers.TopologyCostsJSONSerializer
 * 
 */

package it.garr.greenmst.web.serializers;

import it.garr.greenmst.types.TopologyCosts;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class TopologyCostsJSONDeserializer extends JsonDeserializer<TopologyCosts> {

	@Override
	public TopologyCosts deserialize(JsonParser jParser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		jParser.nextToken();
        
        if (jParser.getCurrentToken() != JsonToken.START_OBJECT) throw new IOException("Expected START_OBJECT");

        while (jParser.nextToken() != JsonToken.END_OBJECT) {
            if (jParser.getCurrentToken() != JsonToken.FIELD_NAME) throw new IOException("Expected FIELD_NAME");

            String name = jParser.getCurrentName();
            jParser.nextToken();
            if (jParser.getText().equals("")) continue;
            Integer value = Integer.parseInt(jParser.getText());
            
            map.put(name, value);
        }
    	
        TopologyCosts costs = new TopologyCosts();
		costs.setCostsValues(map);
		
		return costs;
	}

}