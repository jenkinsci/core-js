package net.sourceforge.htmlunit;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Scriptable;

/**
 * Misc utilities.
 * @author Marc Guillemot
 */
public class Utilities {
	/**
	 * Execute the provided script in a fresh context
	 * @param script the script
	 */
	static void executeScript(final String script) {
		final ContextAction action = new ContextAction()
		{
			public Object run(Context cx) {
				final Scriptable scope = cx.initStandardObjects();
				return cx.evaluateString(scope, script, "test", 0, null);
			}
		};
		ContextFactory.getGlobal().call(action);
	}

}
