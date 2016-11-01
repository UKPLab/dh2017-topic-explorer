/** *****************************************************************************
  * Copyright 2016
  * Ubiquitous Knowledge Processing (UKP) Lab
  * Technische Universität Darmstadt
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  *
  * *****************************************************************************/
package de.tudarmstadt.ukp.topicexplorer.csv

import java.io.File

import org.scalatest.FunSuite

class CsvModelParserTest extends FunSuite {
  val modelFile = new File("src/test/resources/model.tsv")

  def getParser: CsvModelParser = {
    new CsvModelParser(modelFile)
  }

  test("query for 'upon'") {
    val expected = "(0.1)\tupon: 3\tthey: 3\tfat: 3\tcold: 3\tabove: 2\tcontinued: 2\tunsatiable: 2\tbringing: 2\tdoors: 2\trich: 2"
    val query = "upon"
    assert(expected === getParser.query(query))
  }

  test("query for non-existent token") {
    val query = "non-existent"
    assert(getParser.query(query).isEmpty)
  }

  test("query for 'the'") {
    val expected = "(0.1)\tthe: 9\thad: 7\tend: 5\tshe: 4\tmen: 3\tleave: 2\tShy: 2\tapartments: 2\tthemselves: 2\tweeks: 2"
    val query = "the"
    assert(expected === getParser.query(query))
  }

  test("query for two tokens") {
    val expected = "(0.1)\tupon: 3\tthey: 3\tfat: 3\tcold: 3\tabove: 2\tcontinued: 2\tunsatiable: 2\tbringing: 2\tdoors: 2\trich: 2"
    val query = "upon they"
    assert(expected === getParser.query(query))
  }

  test("query for two tokens with extra whitespace") {
    val expected = "(0.1)\tupon: 3\tthey: 3\tfat: 3\tcold: 3\tabove: 2\tcontinued: 2\tunsatiable: 2\tbringing: 2\tdoors: 2\trich: 2"
    val query = "upon   they"
    assert(expected === getParser.query(query))
  }

  test("query for low-count token") {
    val query = "pretty"
    val expected = "(0.1)\tupon: 3\tthey: 3\tfat: 3\tcold: 3\tabove: 2\tcontinued: 2\tunsatiable: 2\tbringing: 2\tdoors: 2\trich: 2\tpretty: 1"
    assert(expected === getParser.query(query))
  }
}
