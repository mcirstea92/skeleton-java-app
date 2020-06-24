package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void knowsWhoWroteRomeoAndJuliet() throws Exception {
        assertThat(queryProcessor.process("Who wrote Romeo And Juliet"), containsString("Shakespeare"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("who wrote romeo and juliet"), containsString("Shakespeare"));
    }

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void returns2040when2020plus20() throws Exception {
        assertThat(queryProcessor.process("what is 2020 plus 20"), is("2040"));
    }

    @Test
    public void returns2040whenlargest2020_2040() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest:2020,2040"), is("2040"));
    }
}
