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
package de.tudarmstadt.ukp.topicexplorer

import org.scalatest.FunSuite

class UtilTest extends FunSuite {
  test("harmonic mean integers with 0") {
    val expected = 0d
    val s = Seq(0, 1, 2)
    assert(expected === Util.harmonicMean(s))
  }

  test("empty seq") {
    val expected = 0d
    val s = Seq.empty[Int]
    assert(expected === Util.harmonicMean(s))
  }

  test("harmonic mean 1 and 2") {
    val expected = 1.3333333333333333
    val s = Seq(1, 2)
    assert(expected === Util.harmonicMean(s))
  }

  test("harmonic mean 10, 50, 100") {
    val expected = 23.076923076923077
    val s = Seq(10, 50, 100)
    assert(expected === Util.harmonicMean(s))
  }
}
