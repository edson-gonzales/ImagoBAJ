package core;
import java.io.File;

public class Path
{
       private String path;
       private String separator;
       public Path()
       {
           path = System.getProperty("user.dir")+File.separator;
           separator = File.separator;
       }
       public Path(String path)
       {
           this.path = path;
           separator = File.separator;
       }

        public String getNewPath()
        {
            String newPath = "";
            int indexBegin = 0;

            for (int position = 0 ; position < path.length() ; position++)
            {
                String c = path.charAt(position) + "";
                if(separator.equals(c))
                {
                    newPath = newPath + path.substring(indexBegin, position) + "/";
                    indexBegin = indexBegin + (position - indexBegin + 1);
                }
            }
            return newPath;
        }

}