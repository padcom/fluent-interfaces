package org.example.selenium;

/**
 * Scenario interface
 *
 * @author Maciej Hryniszak
 *
 * @param <Input> Entry page
 * @param <Output> Exit page
 */
public interface Scenario<Input extends Page, Output extends Page> {
	Output run(Input entry);
}
