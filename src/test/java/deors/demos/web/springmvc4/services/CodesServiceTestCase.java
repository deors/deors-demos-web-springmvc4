package deors.demos.web.springmvc4.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

import deors.demos.web.springmvc4.entities.Codes;
import deors.demos.web.springmvc4.entities.CodesImpl;
import deors.demos.web.springmvc4.repositories.CodesDAO;
import deors.demos.web.springmvc4.services.CodesService;
import deors.demos.web.springmvc4.services.CodesServiceImpl;

public class CodesServiceTestCase {

    @Test
    public void testSelectAll() {

        List<Codes> mockData = new ArrayList<Codes>();
        mockData.add(new CodesImpl("A", "active"));
        mockData.add(new CodesImpl("C", "cancelled"));

        CodesDAO mockDAO = EasyMock.createMock(CodesDAO.class);
        mockDAO.selectAll();
        EasyMock.expectLastCall().andReturn(mockData);

        EasyMock.replay(mockDAO);

        CodesService svc = new CodesServiceImpl();
        svc.setCodesDAO(mockDAO);

        Collection<? extends Codes> result = svc.selectAll();

        EasyMock.verify(mockDAO);

        assertEquals(mockData, result);
    }

    @Test
    public void testSelectOne() {

    	Codes inputData = new CodesImpl();
    	inputData.setCode("C");
    	inputData.setValue("");
        Codes mockData = new CodesImpl("C", "cancelled");

        CodesDAO mockDAO = EasyMock.createMock(CodesDAO.class);
        mockDAO.select(inputData);
        EasyMock.expectLastCall().andReturn(mockData);

        EasyMock.replay(mockDAO);

        CodesService svc = new CodesServiceImpl();
        svc.setCodesDAO(mockDAO);

        Codes result = svc.select(inputData);

        EasyMock.verify(mockDAO);

        assertEquals(mockData, result);
        assertEquals(mockData.getCode(), result.getCode());
        assertEquals(mockData.getValue(), result.getValue());
    }

    @Test
    public void testInsert() {

    	Codes inputData = new CodesImpl("D", "delayed");
    	Codes mockData = new CodesImpl("D", "delayed");

        CodesDAO mockDAO = EasyMock.createMock(CodesDAO.class);
        mockDAO.insert(inputData);
        EasyMock.expectLastCall().andReturn(mockData);

        EasyMock.replay(mockDAO);

        CodesService svc = new CodesServiceImpl();
        svc.setCodesDAO(mockDAO);

        Codes result = svc.insert(inputData);

        EasyMock.verify(mockDAO);

        assertEquals(mockData, result);
    }

    @Test
    public void testUpdate() {

    	Codes inputData = new CodesImpl("D", "delayed");

        CodesDAO mockDAO = EasyMock.createMock(CodesDAO.class);
        mockDAO.update(inputData);
        EasyMock.expectLastCall().andReturn(1);

        EasyMock.replay(mockDAO);

        CodesService svc = new CodesServiceImpl();
        svc.setCodesDAO(mockDAO);

        int result = svc.update(inputData);

        EasyMock.verify(mockDAO);

        assertEquals(1, result);
    }

    @Test
    public void testDelete() {

    	Codes inputData = new CodesImpl("D", "delayed");

        CodesDAO mockDAO = EasyMock.createMock(CodesDAO.class);
        mockDAO.delete(inputData);
        EasyMock.expectLastCall().andReturn(1);

        EasyMock.replay(mockDAO);

        CodesService svc = new CodesServiceImpl();
        svc.setCodesDAO(mockDAO);

        int result = svc.delete(inputData);

        EasyMock.verify(mockDAO);

        assertEquals(1, result);
    }
}
