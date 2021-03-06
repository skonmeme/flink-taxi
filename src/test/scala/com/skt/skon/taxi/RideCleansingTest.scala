package com.skt.skon.taxi

import com.skt.skon.taxi.datatypes.TaxiRide
import com.skt.skon.taxi.utils.GeoUtils
import org.joda.time.DateTime
import org.scalatest.FunSuite

class RideCleansingTest extends FunSuite {

  def fixture = new {
    val aPennStation: TaxiRide =  testRide(-73.9947F, 40.750626F, -73.9947F, 40.750626F)
    val toThePole: TaxiRide =     testRide(-73.9947F, 40.750626F, 0, 90)
    val fromThePole: TaxiRide =   testRide(0, 90, -73.9947F, 40.750626F)
    val atNorthPole: TaxiRide =   testRide(0, 90, 0, 90);
  }

  test("This location should be in NYC") {
    val f = fixture
    assertResult(f.aPennStation) {
      f.aPennStation
    }
  }

  def testRide(startLon: Float, startLat: Float, endLon: Float, endLat: Float): TaxiRide =
    new TaxiRide(1L, true, new DateTime(0), new DateTime(0), startLon, startLat, endLon, endLat, 1, 0, 0)

}
