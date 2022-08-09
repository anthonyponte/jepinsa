/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthonyponte.jepinsa.glazedlist;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.UniqueList;
import ca.odell.glazedlists.matchers.AbstractMatcherEditor;
import ca.odell.glazedlists.matchers.Matcher;
import ca.odell.glazedlists.swing.AdvancedListSelectionModel;
import ca.odell.glazedlists.swing.DefaultEventListModel;
import static ca.odell.glazedlists.swing.GlazedListsSwing.eventListModelWithThreadProxyList;
import static ca.odell.glazedlists.swing.GlazedListsSwing.eventSelectionModelWithThreadProxyList;
import com.anthonyponte.jepinsa.model.Documento;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Anthony Ponte
 */
public class StatusResponseSelect extends AbstractMatcherEditor<Documento>
        implements ListSelectionListener {

    private final JList list;
    private final EventList<Documento> billList;
    private EventList<String> statusList;
    private EventList<String> statusSelectedList;

    public StatusResponseSelect(JList list, EventList<Documento> billList) {
        this.list = list;
        this.billList = billList;
    }

    public void confJList() {
        EventList<String> usersNonUnique = new DocumentoToStatusResponseList(billList);
        statusList = new UniqueList<>(usersNonUnique);

        DefaultEventListModel<String> model = eventListModelWithThreadProxyList(statusList);
        list.setModel(model);

        AdvancedListSelectionModel<String> selectionModel
                = eventSelectionModelWithThreadProxyList(statusList);
        list.setSelectionModel(selectionModel);
        statusSelectedList = selectionModel.getSelected();

        list.addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        Matcher<Documento> matcher = new DocumentoForStatusResponseMatcher(statusSelectedList);
        fireChanged(matcher);
    }
}
