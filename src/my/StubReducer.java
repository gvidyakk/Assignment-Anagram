package my;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<Text, Text, Text, Text> {

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
	  
	  String all_Anagrams_with_key_Alphabets = "";
	  
	  String Modified_key = "All Anagrams with the alphabets: "+key.toString();
	  
	  
	  while( values.iterator().hasNext())
	  {
		  all_Anagrams_with_key_Alphabets = all_Anagrams_with_key_Alphabets+" "+values;  
	  
	  }
	  context.write(new Text(Modified_key), new Text(all_Anagrams_with_key_Alphabets));
  }
}
