# Ex3
this is a project in our opp course in ariel university 
it can make csv file to kml formt that can be seen in google earth 
eliahu satat nashon satat.

Descreption
The project represents a game called Pacman aand fruits , the game is performed on img of Google Earth. The course of the game: Choose a map location for Pacmans and fruits, then the goal of the Pacmans to eat the fruits in the shortest time (in terms of time), the end of the game: Will be displayed on the map any track that Packman has made There is an example below the map.

abute the Algorithms read:
https://github.com/davidsatat/Ex2/wiki

it base on ex2 so its include:
mycoords class
Represents a Class that allows us to perform calculations between GPS points such as:

Move a point with a vector
Calculates a vector between two points
Azimuth calculation, Elevation
Distance between two points ..
File format
The File format package has:

CSV2Kml class
The class has two functions:

CSV2Kml function accepts a .csv file as a PATH, And manually converts it to a .kml file.
Object2Kml function accepts a project. Which inside it has layers and within layers there is information with points, Then the function converts the points to the directions on the map (each route on the map represents a layer)

Geom
Geom package represents shapes in space:

GPSPoint: lat,long,alt (regular GPS Point )
Point3D : can represents GPSPoint and vec .
Gis package
This package represents a data structure that contains GPS points information:

Meta_Data : represents Data according to class. For example, in GIS_Element the data represents the information on the point such as color time, etc. (comprehensive documentation is found in the departments themselves, see doc folder). Each point is reserved as an element which has information for each point such as: accuracy, name, etc.
GIS_Element : Represents a GPS point of a map with information about the point.
GIS_Layer : Represents a collection of points / directions on the map. (Similar to one csv file)
GIS_Project : Represents a collection of layers / tracks on the map. (Similar to the folder of .csv files)

and more to ex3

ExampleGameMap
ariel1

Sorces
converting coordinates : https://stackoverflow.com/questions/1185408/converting-from-longitude-latitude-to-cartesian-coordinates

how to convert csv to kml(from the resource) : http://convertcsv.com/csv-to-kml.htm

