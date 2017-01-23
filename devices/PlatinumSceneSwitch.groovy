/**
 *  Hunter Douglas Platinum Gateway Scene Control Switch for SmartThings
 *  Schwark Satyavolu
 *  Originally based on: Allan Klein's (@allanak) and Mike Maxwell's code
 *
 *  Usage:
 *  1. Add this code as a device handler in the SmartThings IDE
 *  3. Create a device using PlatinumGatewaySceneSwitch as the device handler using a hexadecimal representation of IP:port as the device network ID value
 *  For example, a gateway at 192.168.1.222:522 would have a device network ID of C0A801DE:20A
 *  Note: Port 522 is the default Hunter Douglas Platinum Gateway port so you shouldn't need to change anything after the colon
 *  4. Enjoy the new functionality of the SmartThings app
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */

metadata {
	definition (name: "Platinum Gateway Scene Switch", namespace: "schwark", author: "Schwark Satyavolu") {
	capability "Switch"
	}

simulator {
		// TODO: define status and reply messages here
	}

tiles {
	standardTile("switch", "device.switch", width: 1, height: 1, canChangeIcon: true) {
        	state "on", label: '${name}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
        	state "off", label: '${name}', action: "switch.on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
   		}
	}

preferences {
    input name: "sceneNo", type: "number", title: "Scene Number", description: "Enter the number of Scene in your App", required: false,
          displayDuringSetup: false
}

    main "switch"
    details(["switch"])
}

def updated() {
}

def on() {
	return parent.runScene(sceneNo)
}

def off() {
	return parent.runScene(sceneNo)
}



