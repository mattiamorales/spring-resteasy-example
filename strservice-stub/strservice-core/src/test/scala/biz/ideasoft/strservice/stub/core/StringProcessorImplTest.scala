package biz.ideasoft.strservice.stub.core

import org.scalatest.{Matchers, FlatSpec}

class StringProcessorImplTest extends FlatSpec with Matchers {

  behavior of "StringProcessorImplTest"

  it should "calculateLength" in {
    val strProcessor = new StringProcessorImpl()

    val res = strProcessor.calculateLength("hello")

    res.getLength shouldBe 5

  }

}
