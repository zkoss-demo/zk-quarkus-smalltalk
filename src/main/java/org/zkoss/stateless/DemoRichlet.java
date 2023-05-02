package org.zkoss.stateless;

import java.util.List;

import org.zkoss.stateless.annotation.Action;
import org.zkoss.stateless.annotation.ActionVariable;
import org.zkoss.stateless.annotation.RichletMapping;
import org.zkoss.stateless.sul.IComponent;
import org.zkoss.stateless.sul.ILabel;
import org.zkoss.stateless.ui.Locator;
import org.zkoss.stateless.ui.StatelessRichlet;
import org.zkoss.stateless.ui.UiAgent;
import org.zkoss.stateless.ui.util.Immutables;
import org.zkoss.zk.ui.event.Events;

@RichletMapping("/demo")
public class DemoRichlet implements StatelessRichlet {

	@RichletMapping("")
	public List<IComponent> index() {
		return Immutables.createComponents("stateless-page.zul", null);
	}

	@Action(from = "#calculate", type = Events.ON_CLICK)
	public void calculate(@ActionVariable(targetId = "firstMember", field = "value") int firstMemberValue,
			@ActionVariable(targetId = "secondMember", field = "value") int secondMemberValue,
			@ActionVariable(targetId = "operation", field = "selectedIndex") int operation) {
		
		int result = 0;
		switch (operation) {
		case 0: {
			result = firstMemberValue + secondMemberValue;
			break;
		}
		case 1: {
			result = firstMemberValue * secondMemberValue;
			break;
		}
		default:
			result = 0;
			break;
		}
		UiAgent.getCurrent().smartUpdate(Locator.ofId("result"), new ILabel.Updater().value("result: "+result));
	}

}
