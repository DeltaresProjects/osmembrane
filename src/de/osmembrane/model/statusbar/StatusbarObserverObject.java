/*
 * This file is part of the OSMembrane project.
 * More informations under www.osmembrane.de
 * 
 * The project is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 * for more details about the license see
 * http://www.osmembrane.de/license/
 * 
 * Source: $HeadURL$ ($Revision$)
 * Last changed: $Date$
 */

package de.osmembrane.model.statusbar;

public class StatusbarObserverObject {

	private StatusbarEntry entry;

	public StatusbarObserverObject(StatusbarEntry entry) {
		this.entry = entry;
	}

	public StatusbarEntry getEntry() {
		return entry;
	}
}
