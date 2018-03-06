package com.dy.kata.poker.v1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParserTest {
    @Test
    public void test_parse_player() throws Exception {
        Parser parser = new Parser();
        Player player = parser.parse("Black: 2H 3D 5S 9C KD");

        assertThat(player.getName(), is("Black"));
        assertThat(player.getHand(), is("2H 3D 5S 9C KD"));
    }

}