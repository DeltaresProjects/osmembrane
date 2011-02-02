package de.osmembrane.model.settings;

import de.osmembrane.model.pipeline.AbstractFunction;
import de.osmembrane.model.pipeline.CopyType;

/**
 * @author jakob_jarosch
 * 
 */
public class FunctionPreset extends AbstractFunctionPreset {

	private static final long serialVersionUID = 2011020221170001L;

	private String name;
	private AbstractFunction function;

	public FunctionPreset(String name, AbstractFunction function) {
		this.name = name;
		this.function = function.copy(CopyType.WITHOUT_POSITION);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void loadPreset(AbstractFunction function) {
		for (int task = 0; task < this.function.getAvailableTasks().length; task++) {
			for (int param = 0; param < this.function.getAvailableTasks()[task]
					.getParameters().length; param++) {

				/* check if parameter values equals */
				try {
					if (this.function.getAvailableTasks()[task].getParameters()[param]
							.getName().equals(
									function.getAvailableTasks()[task]
											.getParameters()[param].getName())) {
						function.getAvailableTasks()[task].getParameters()[param]
								.setValue(this.function.getAvailableTasks()[task]
										.getParameters()[param].getValue());
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					/* just ignore, not so important */
				}
			}
		}
	}

	@Override
	protected AbstractFunction getInheritedFunction() {
		return function;
	}
}