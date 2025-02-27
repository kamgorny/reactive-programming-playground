package monoservice;

import common.Util;

public class MonoFileServiceExample
{
    public static void main(String[] args)
    {
     MonoFileService monoFileService = new MonoFileService();

     monoFileService.read("test_file.txt").subscribe(Util.subscriber());
     monoFileService.write("test_file.txt", "dupaaaa").subscribe(Util.subscriber());
     monoFileService.read("test_file.txt").subscribe(Util.subscriber());
//     monoFileService.delete("test_file.txt").subscribe(Util.subscriber());
//     monoFileService.read("test_file.txt").subscribe(Util.subscriber());

    }
}
