package com.guliash.calculator.storage;

import com.guliash.calculator.structures.CalculatorDataSet;

import java.util.List;

/**
 * Base interface for a dataSets storage
 */
public interface Storage {

    /**
     * Adds new dataSet to the storage
     *
     * @param dataSet dataSet to add
     * @return {@code true} if the dataSet was added, {@code false} if the dataSet already present
     */
    boolean addDataSet(CalculatorDataSet dataSet);

    /**
     * Updates an already added dataSet
     *
     * @param dataSet dataSet to update
     * @return {@code true} if the dataSet was updated, {@code false} if the dataset was not added previously
     */
    boolean updateDataSet(CalculatorDataSet dataSet);

    /**
     * Checks if the dataSet was already added
     *
     * @param dataSet the dataSet to check
     * @return {@code true} if the dataSet presents in storage, {@code false} otherwise
     */
    boolean hasDataSet(CalculatorDataSet dataSet);

    /**
     * Deletes the dataSet from the storage
     *
     * @param dataSet the dataSet to delete
     * @return {@code true} if the dataSet was deleted, {@code false} if the dataSet was not previously added
     */
    boolean deleteDataSet(CalculatorDataSet dataSet);

    /**
     * Returns a list of all dataSets sorted by timestamp (the later ones first)
     *
     * @return the result list
     */
    List<CalculatorDataSet> getDataSets();

    /**
     * Releases all resources needed by the storage
     */
    void releaseResources();

    /**
     * Clears all
     */
    void clear();
}
