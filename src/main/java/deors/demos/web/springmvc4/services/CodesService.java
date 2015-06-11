package deors.demos.web.springmvc4.services;

import java.util.Collection;

import deors.demos.web.springmvc4.entities.Codes;
import deors.demos.web.springmvc4.repositories.CodesDAO;

/**
 * The Codes service interface.
 *
 * @author jorge.hidalgo
 * @version 1.0
 */
public interface CodesService {

    /**
     * Sets the data access object instance.
     *
     * @param codesDAO the DAO instance
     */
    void setCodesDAO(CodesDAO codesDAO);

    /**
     * Returns all Codes records.
     *
     * @return all records
     */
    Collection<? extends Codes> selectAll();

    /**
     * Returns Codes record by the given 'code' value.
     *
     * @param criteria the bean containing the 'code' to be selected
     * @return the selected record
     */
    Codes select(Codes criteria);

    /**
     * Adds a new Codes record.
     *
     * @param record the new record
     * @return the just added record
     */
    Codes insert(Codes record);

    /**
     * Updates existing Codes records.
     *
     * @param record the record to be updated
     * @return number of records updated
     */
    int update(Codes record);

    /**
     * Deletes existing Codes records.
     *
     * @param record the record to be deleted
     * @return number of records deleted
     */
    int delete(Codes record);
}
