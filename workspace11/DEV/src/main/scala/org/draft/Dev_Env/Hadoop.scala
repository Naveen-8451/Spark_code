package org.draft.Dev_Env


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.PrintWriter;

/**
* @author ${user.name}
*/
object Hadoop {

//def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)

def main(args : Array[String]) {
println( "Trying to write to HDFS..." )
val conf = new Configuration()
//conf.set("fs.defaultFS", "hdfs://quickstart.cloudera:8020")
conf.set("fs.defaultFS", "hdfs://localhost:9000")
val fs= FileSystem.get(conf)
val output = fs.create(new Path("/project/mySample.txt"))
val delete = fs.delete(new Path("/project/mySample.txt"))
val writer = new PrintWriter(output)
try {
    writer.write("this is a test") 
    writer.write("\n")
}
finally {
    writer.close()
    println("Closed!")
}
println("Done!")
}

}