using System;
namespace WorldCreator
{
	public class Coordinate
	{
		private double x;
		public double X { get { return x; } set { x = value; } }

		private double y;
		public double Y { get { return y; } set { y = value; } }

		private double z;
		public double Z { get { return z; } set { z = value; } }

		public Coordinate(double x, double y, double z)
		{
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
