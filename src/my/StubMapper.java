package my;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//public class StubMapper extends Mapper<Object, Text, Text, Text> {

public class StubMapper extends Mapper<Object, Text, Text, Text> {

  @Override
  public void map(Object key, Text value, Context context)
      throws IOException, InterruptedException {
    /*
     * TODO implement
     */
	 	  
	  String[] words = value.toString().split("[ \t]+");
	  
	  for(String word:words)
	  {
		  char[] Characters = word.toCharArray();
		  
		  Arrays.sort(Characters);
		  
		  String Sorted_Word = Characters.toString();
		  
		  context.write(new Text(Sorted_Word),new Text(word));
	  }
  }
}
