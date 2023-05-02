package org.zkoss.classic;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Messagebox;

public class HelloWorldComposer extends SelectorComposer<Component> {

	@Listen("onClick=#btn")
	public void doBtnClick() {
		Messagebox.show("Hello world from ZK");
	}
	
}
