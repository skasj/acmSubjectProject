package leetCode.exam;

import org.junit.Assert;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class RepeatedSubstringPatternSolution {

    public boolean repeatedSubstringPattern(String s) {
        int[] charCounNums = new int[200];
        // 统计每个字母出现的数量；
        char[] charArray = s.toCharArray();
        if (charArray.length < 2) {
            return false;
        }
        for (char c : charArray) {
            charCounNums[c]++;
        }
        // 获取最大公倍数,一旦一个数值只出现一次就返回false；
        int minCountNums = Integer.MAX_VALUE;
        int maxCountNums = Integer.MIN_VALUE;
        int maxMulNum = Integer.MAX_VALUE;
        for (int i = 0; i < charCounNums.length; i++) {
            if (charCounNums[i] > maxCountNums) {
                maxCountNums = charCounNums[i];
            }
            if (charCounNums[i] != 0 && charCounNums[i] < minCountNums) {
                minCountNums = charCounNums[i];
            }
        }
        maxMulNum = getMinMultiNum(minCountNums, maxCountNums);
        //        int v1 = charArray.length / maxMulNum;
        //        int subStringLength = charArray.length/getMinMultiNum(maxMulNum,v1);
        int subStringLength = charArray.length / maxMulNum;
        // 最小次数值是否大于1，且其他出现次数是最小次数的整数倍
        if (subStringLength == charArray.length || charArray.length % subStringLength != 0) {
            return false;
        }
        // 以第一个子集为标准判断后续子集是否以第一个子集相同
        for (int i = subStringLength; i < charArray.length; i++) {
            if (charArray[i] != charArray[i % subStringLength]) {
                return false;
            }
        }
        return true;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> lastIndexMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> lastSpaceMap = new HashMap<Integer, Integer>();
        Integer lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lastIndexMap.get(nums[i]) != null) {
                lastIndex = lastIndexMap.get(nums[i]);
                lastSpaceMap.put(nums[i], Math.min(i - lastIndex, lastSpaceMap.getOrDefault(nums[i], Integer.MAX_VALUE)));
            }
            lastIndexMap.put(nums[i], i);
        }
        Collection<Integer> values = lastSpaceMap.values();
        if (values.isEmpty()) {
            return false;
        }
        return k >= Collections.min(values);
    }

    public int getMinMultiNum(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        int k = 2;
        while (k < b) {
            if (b % k == 0 && a % k == 0) {
                return k;
            }
            k++;
        }
        return k;
    }

    public static void main(String[] args) {
        RepeatedSubstringPatternSolution solution = new RepeatedSubstringPatternSolution();
//        Assert.assertFalse(solution.repeatedSubstringPattern("aba"));
//        Assert.assertFalse(solution.repeatedSubstringPattern("a"));
//        Assert.assertTrue(solution.repeatedSubstringPattern("aaaa"));
//        Assert.assertTrue(solution.repeatedSubstringPattern("abcabc"));
//        Assert.assertTrue(solution.repeatedSubstringPattern("abcabcabcabc"));
//        Assert.assertFalse(solution.repeatedSubstringPattern("abcabcabcab"));
//        Assert.assertTrue(solution.repeatedSubstringPattern(
//                "babbaaabbbbabbaaabbbbabbaaabbbbabbaaabbbbabbaaabbbbabbaaabbbbabbaaabbbbabbaaabbbbabbaaabbbbabbaaabbb"));
//        Assert.assertTrue(solution.repeatedSubstringPattern(
//                "jqjtsuzcfkrwrxygcmfaqgttyitteudnkmgegginsbkjyksbyxdrfwkfhfylzbalqjpyrxmjzyvxknyimezramyjrxwtaxesgurxtfiudfspssxgwzzzlykevhxxgeqmahltovorbiivcfczgdatbkaytxwzdondvazjwpczxkwzraaaecthnvggteiysvcpwdausevrqrsjstjwxffkaltvrbulyyaudcqvglowdggxbpvzwalxogufhotioteryvoeicbnljkoahnxibwwhqdrhwzxsfpqadujixytijjjqziaaewjwccfyddqjuijzduhctclemwwlexnkvwizzoyctqlnzxoetyioavsorrbvoqflpqlqgluzdgoefckaatpdohtgaxdqnlcebpuhapgfxwkcaucbnrgebbmdypuoaysdnnkpesuboedrbhuqbauedghcydsabmeoboffjcgzglqjvkawmucqdlubpmbqyfhcwmhfoogxzxguhiswdwmiigjzumpuuywsnezdufctcjqmrkiwhwerepqyehsyirqvxryrwbmbmepfpzeyvkrzajzesteakwvhnwalznmnrbuicygxjxylixrbtvbdrzngxnrwcglujfcmellpkmctltueqvkjuxprmippoajyinmmyxdjjfevayzqtlzqiojxybmndxllmxzlwcwgjadjaebvqalaqxxpyjedippvooimtgucixoierfwsrwkqubqfftqwinmxvzsdtwltmvxeatytrillkbtpvlofyaetzwyttlofiljkghexspletgvqrjvpkakjyietvszdfknlutlojyseenuxxpohrysqixldpkivxvitpvhatbezoawnpkwjkpbummzdzhayflrugawcbabrayhrkdcxsdrgsrmrampfzibgkxinzlgbjntwrvtlbmstfemisdnslpavokkovqphekfxiaijmaeugqcbtrvggvdxfnlcdajjnqgvqpedrizaabbtswbbteyatlcwnoiaeovvdbaxlzxlcygwwhzpnzpgkrfahnambyjhzlelkbwobfkxmkmcjbiwupwccwqguznwmrhyufmvkyszigbuhlsdbofdmxjjyyfkroiltuievcffigzrtrvuhcaucldakkldyvprszxnecsmkugendavhapjmukyexdcsutmutzyvumiosmbxmwfpnodhadnxgpsblevegvbahlqcxrzmqebfvgpvjcvpupqfvnlbiodsatuznvldcoixuxudcpvwelbcbodjejdecxgpttuviduecokeefaksdottsfabigfgmxbgryqusuziefojibcnpvjhcjklpstcpuiguydouewzjlkrmmhbkqlmzxzopssgmcnicswxwtwheibqvithyevzevptnicckpknjhmhakogspypzrwxyuycpoxewzgiqtxzcjgetxkmmkbobanbumdladpycygtrgutpdzlajzovccwcqaycfjeibclzkgsqanifmtfxsusuyqzoqxsyjwgkatllbfdesljggpdalxvjnwygvqegpmspgdcjignctxiaonazkxiyvigrbkzqwsfexiogodkjatlqioptlatjkzcllbbhthorpezfhjqkecapqsidubmecoqnsrulakerofyyrpivrkkheumyxzdzpvmhmjvpvbgkhfkyusvneiwjcijajmbzjqiwzfnuhtgoaqmukhjrpfauojwzyxyhnjfooslxorlokzlwjunaanuqzqpzqqifzoupifnwyankayhjsujukgklyckqsswtiskrzxpzackccrlxnwrxecifeuvynrrxlbqkbgkdkufpnsmaqdavhkanfxluperciinlqxoctvrindifjkaqvcgaaruryntivitnhjqcghktnvywfbocfuchoyammwwjerxoapqiwbblwbjdeygksktijuwxqsiwjhklwbtvcwgaaqfeqlqkykthgpgwkostwfhsgapkzwmzorfefwofihmozumjkgeilldtosfnorocltisrxxbelrdhdormtaxeftuxyhosxsdtbxkyuoehfkolyfxthwympskqcaibsnutkhtevylciznigkcohccywooaoychlycvfwbcuofepuowfqmouoordfttdvapudkbzmgvclzsfpomiaccqtvvyppdmrsiufkvtqqvdrnkjbzrddtwwrtwiiaucsdwzpushmomgdyphxgmdbibucycmyxoscnutjmcvcqdgoupocbremuaqsdcsctneihzrvboyrsghmvvpyovkjvadadwcylggshzninnbhvjusglrvibgdejgjfihqrpkyoajdpkllvhfeswzaahfeqlnyuwqnlblbdwesjpdewjiohjqjqynjlchhyxulagmdcrwlgbsfmcvwomfgmtpxxyfywzjyhycmpyxxbrcowakkmpqakixkgciectdjrhvghvgiokykkkuycnymvwydagicanorwladiilxsmhfwedytenocltcsdfusvnognrrvfoqrxvpdyowedmgoijilqeelsstfmkdtatkaobforctuqbjyktmayqnqkhxytarwvdyjfdawhvrywcyhxkjvcxnpglnbnfxjkxspbuoiphimjhvgteewbrnhcajqhibugtjjqzrfgctploygteewvrgaupsbztxhohqegkmpmfezuefpiklgbrgviazktwrjfiooucdihjhdqosayegcxozgoaqjzjtgtjunlzvuleydvqdtwkxuazcpzuaafthzedorfmmqqktlcyhbigvjfzahvahawozcsouxaipsukgwipztvuebvgiqgpregqhagdzilobfajdiyddtzhwvpgnwyecexlgfofozvrgvamfarlvsuspkydiyjkegwkokpcmkvuhvipvzaquwkjglmojyzogxyuhqwvctsmoadlcfewbqfibuwnuxdaudvevtbyntmduprwuvuvnbdrvcepzjswmnckidivxubrjspdplacmetkizbjktfzihjrltoknpdyhsdyfdbrjwdryfbkagjjqscdlqnagqapkdophrispmkptlattjelegorxbufruwdymshdbzvplkiykbuwgfcowtlznsrkpwibprhsscheopebsyzagbpcwcbmvuwmrgpixwarajvpycssartgskkqomcjiaxzgnhfljxmsudswvlxogfgsqygebsmbpoiexpqhmebhhufehespkahcyngbhudzindgevprzqaikfotkiiwkpyjfgmoapnjetrjogcqweajjrevzntkervlzhaaznlficqziupgyrrkiwfkjzwpsrbsabszqfhzhxarspzqirctpifajbpbusvutpwmudnbcnuweuponrhczmckntmjmjehzattfixjvrgbnvqamxcomgybcmlowpvvrrqyznhxfnyskotzoxnagnbicoyafvvymnwobglgtlagcvfqvssbhvljkjjpegotukhvsudohdujbzbwttxcpkmztxqzeesarbxjxaxfftqgsscnlbqclcbebsgfyyhpcebzgagmuxuopxccasfmwisxcyfbzmsdtvezwlnqiiezhibhaivyroytoduprpukkzmgkzyuhdtolwyoftmwjmpapmrjbmvllhsxhsrqvkhjgfznynjkabkrnbaonybafvxooohlaoujtvwtjifjjpawtdmgbpjilgzbxgmxujipehkppqyyhbwaekjhzspmaqpxwexsnfjtmujbmhbvkxwqjhxlbpzbfpzctwwibgbqcmrqwvlgsjxesuptlqvrhuvasrktzmldydtwyhdsqaylwpekgzbnvyqnrajrouupxqlxxospqqapgfzmgcbccrptsymitjxszjswzknqaqhgviudkwfmpxhjvusqdpjcadaanpsnfzwchsgtqlhikorgijylbjpbmrdzhxpmwnpffvayihgtyxbgjzumllpxdtxkqowpbnwikzgtioogoppxqljbwybbtanmomdrzzzkyifjytpmkejcrueovhrohfavrdmqfncfxhowcgimmupeovulclalqcghiuaphcwfkndmtlbfhsjypdjtrlehokrygrpnvluhyxutlxzspkqgqczhndqdphbvaskwghfeezyryzmpjevzguiuzzxoiblltwhbdogjogdofpeqvzqcwawvzvmiwztsxctaqbmgjrvoibhdazfwzdszbgjzferdinfaqthakeqsfzyhyfeyjyxkgijlmdqwswwkrfmcjfwqewadcebneazmkkxynquhmqudwghhlgascavggytkyswidvislcczswfqemaquaizaffgdzsdtqnwlvrzxtyrpdivsinokxnkctsfukinavknsdmpwnhnqrikbwzltmvyhnfbzopzlbmeebvcocpgvzrwxshreerotwpsmgtyjienjbrzggfbiyafqjyxopljmceyjzysheisgzrmiznqxpvqzunpjyavaewleuenzogfnztvyilyyjoxdbmobmmdtipzevmdjskwudusmhqmqgjvhxmklyogidfmassjmehgkdzylrkbytzhslsfjgmtlrhljbwwgfcqjdquxaxvvwenjwsucenpyxchyyfeekwppmjmoijjhoyqkrlpxaexxhhwhmcnybcopnaewkpdyovkhizgjgeiplgwzjkymoobcqhaaxfalanujmauseehrlgtwsrighlkxtkaqpcdspxdczzwgdgxqmqmgjwmqkxqdjqvbuatkzwoyxkeascrgufmgezwoyotjgokbqflpdznalsbgwumsbzyhyxvylqhseutwzgldhzfutgapcnhgminmfjmqbvkgpferlqwupbpikrzoeiusqigvtsouoycfehwrxsmowdyguzubhptazajqjtsuzcfkrwrxygcmfaqgttyitteudnkmgegginsbkjyksbyxdrfwkfhfylzbalqjpyrxmjzyvxknyimezramyjrxwtaxesgurxtfiudfspssxgwzzzlykevhxxgeqmahltovorbiivcfczgdatbkaytxwzdondvazjwpczxkwzraaaecthnvggteiysvcpwdausevrqrsjstjwxffkaltvrbulyyaudcqvglowdggxbpvzwalxogufhotioteryvoeicbnljkoahnxibwwhqdrhwzxsfpqadujixytijjjqziaaewjwccfyddqjuijzduhctclemwwlexnkvwizzoyctqlnzxoetyioavsorrbvoqflpqlqgluzdgoefckaatpdohtgaxdqnlcebpuhapgfxwkcaucbnrgebbmdypuoaysdnnkpesuboedrbhuqbauedghcydsabmeoboffjcgzglqjvkawmucqdlubpmbqyfhcwmhfoogxzxguhiswdwmiigjzumpuuywsnezdufctcjqmrkiwhwerepqyehsyirqvxryrwbmbmepfpzeyvkrzajzesteakwvhnwalznmnrbuicygxjxylixrbtvbdrzngxnrwcglujfcmellpkmctltueqvkjuxprmippoajyinmmyxdjjfevayzqtlzqiojxybmndxllmxzlwcwgjadjaebvqalaqxxpyjedippvooimtgucixoierfwsrwkqubqfftqwinmxvzsdtwltmvxeatytrillkbtpvlofyaetzwyttlofiljkghexspletgvqrjvpkakjyietvszdfknlutlojyseenuxxpohrysqixldpkivxvitpvhatbezoawnpkwjkpbummzdzhayflrugawcbabrayhrkdcxsdrgsrmrampfzibgkxinzlgbjntwrvtlbmstfemisdnslpavokkovqphekfxiaijmaeugqcbtrvggvdxfnlcdajjnqgvqpedrizaabbtswbbteyatlcwnoiaeovvdbaxlzxlcygwwhzpnzpgkrfahnambyjhzlelkbwobfkxmkmcjbiwupwccwqguznwmrhyufmvkyszigbuhlsdbofdmxjjyyfkroiltuievcffigzrtrvuhcaucldakkldyvprszxnecsmkugendavhapjmukyexdcsutmutzyvumiosmbxmwfpnodhadnxgpsblevegvbahlqcxrzmqebfvgpvjcvpupqfvnlbiodsatuznvldcoixuxudcpvwelbcbodjejdecxgpttuviduecokeefaksdottsfabigfgmxbgryqusuziefojibcnpvjhcjklpstcpuiguydouewzjlkrmmhbkqlmzxzopssgmcnicswxwtwheibqvithyevzevptnicckpknjhmhakogspypzrwxyuycpoxewzgiqtxzcjgetxkmmkbobanbumdladpycygtrgutpdzlajzovccwcqaycfjeibclzkgsqanifmtfxsusuyqzoqxsyjwgkatllbfdesljggpdalxvjnwygvqegpmspgdcjignctxiaonazkxiyvigrbkzqwsfexiogodkjatlqioptlatjkzcllbbhthorpezfhjqkecapqsidubmecoqnsrulakerofyyrpivrkkheumyxzdzpvmhmjvpvbgkhfkyusvneiwjcijajmbzjqiwzfnuhtgoaqmukhjrpfauojwzyxyhnjfooslxorlokzlwjunaanuqzqpzqqifzoupifnwyankayhjsujukgklyckqsswtiskrzxpzackccrlxnwrxecifeuvynrrxlbqkbgkdkufpnsmaqdavhkanfxluperciinlqxoctvrindifjkaqvcgaaruryntivitnhjqcghktnvywfbocfuchoyammwwjerxoapqiwbblwbjdeygksktijuwxqsiwjhklwbtvcwgaaqfeqlqkykthgpgwkostwfhsgapkzwmzorfefwofihmozumjkgeilldtosfnorocltisrxxbelrdhdormtaxeftuxyhosxsdtbxkyuoehfkolyfxthwympskqcaibsnutkhtevylciznigkcohccywooaoychlycvfwbcuofepuowfqmouoordfttdvapudkbzmgvclzsfpomiaccqtvvyppdmrsiufkvtqqvdrnkjbzrddtwwrtwiiaucsdwzpushmomgdyphxgmdbibucycmyxoscnutjmcvcqdgoupocbremuaqsdcsctneihzrvboyrsghmvvpyovkjvadadwcylggshzninnbhvjusglrvibgdejgjfihqrpkyoajdpkllvhfeswzaahfeqlnyuwqnlblbdwesjpdewjiohjqjqynjlchhyxulagmdcrwlgbsfmcvwomfgmtpxxyfywzjyhycmpyxxbrcowakkmpqakixkgciectdjrhvghvgiokykkkuycnymvwydagicanorwladiilxsmhfwedytenocltcsdfusvnognrrvfoqrxvpdyowedmgoijilqeelsstfmkdtatkaobforctuqbjyktmayqnqkhxytarwvdyjfdawhvrywcyhxkjvcxnpglnbnfxjkxspbuoiphimjhvgteewbrnhcajqhibugtjjqzrfgctploygteewvrgaupsbztxhohqegkmpmfezuefpiklgbrgviazktwrjfiooucdihjhdqosayegcxozgoaqjzjtgtjunlzvuleydvqdtwkxuazcpzuaafthzedorfmmqqktlcyhbigvjfzahvahawozcsouxaipsukgwipztvuebvgiqgpregqhagdzilobfajdiyddtzhwvpgnwyecexlgfofozvrgvamfarlvsuspkydiyjkegwkokpcmkvuhvipvzaquwkjglmojyzogxyuhqwvctsmoadlcfewbqfibuwnuxdaudvevtbyntmduprwuvuvnbdrvcepzjswmnckidivxubrjspdplacmetkizbjktfzihjrltoknpdyhsdyfdbrjwdryfbkagjjqscdlqnagqapkdophrispmkptlattjelegorxbufruwdymshdbzvplkiykbuwgfcowtlznsrkpwibprhsscheopebsyzagbpcwcbmvuwmrgpixwarajvpycssartgskkqomcjiaxzgnhfljxmsudswvlxogfgsqygebsmbpoiexpqhmebhhufehespkahcyngbhudzindgevprzqaikfotkiiwkpyjfgmoapnjetrjogcqweajjrevzntkervlzhaaznlficqziupgyrrkiwfkjzwpsrbsabszqfhzhxarspzqirctpifajbpbusvutpwmudnbcnuweuponrhczmckntmjmjehzattfixjvrgbnvqamxcomgybcmlowpvvrrqyznhxfnyskotzoxnagnbicoyafvvymnwobglgtlagcvfqvssbhvljkjjpegotukhvsudohdujbzbwttxcpkmztxqzeesarbxjxaxfftqgsscnlbqclcbebsgfyyhpcebzgagmuxuopxccasfmwisxcyfbzmsdtvezwlnqiiezhibhaivyroytoduprpukkzmgkzyuhdtolwyoftmwjmpapmrjbmvllhsxhsrqvkhjgfznynjkabkrnbaonybafvxooohlaoujtvwtjifjjpawtdmgbpjilgzbxgmxujipehkppqyyhbwaekjhzspmaqpxwexsnfjtmujbmhbvkxwqjhxlbpzbfpzctwwibgbqcmrqwvlgsjxesuptlqvrhuvasrktzmldydtwyhdsqaylwpekgzbnvyqnrajrouupxqlxxospqqapgfzmgcbccrptsymitjxszjswzknqaqhgviudkwfmpxhjvusqdpjcadaanpsnfzwchsgtqlhikorgijylbjpbmrdzhxpmwnpffvayihgtyxbgjzumllpxdtxkqowpbnwikzgtioogoppxqljbwybbtanmomdrzzzkyifjytpmkejcrueovhrohfavrdmqfncfxhowcgimmupeovulclalqcghiuaphcwfkndmtlbfhsjypdjtrlehokrygrpnvluhyxutlxzspkqgqczhndqdphbvaskwghfeezyryzmpjevzguiuzzxoiblltwhbdogjogdofpeqvzqcwawvzvmiwztsxctaqbmgjrvoibhdazfwzdszbgjzferdinfaqthakeqsfzyhyfeyjyxkgijlmdqwswwkrfmcjfwqewadcebneazmkkxynquhmqudwghhlgascavggytkyswidvislcczswfqemaquaizaffgdzsdtqnwlvrzxtyrpdivsinokxnkctsfukinavknsdmpwnhnqrikbwzltmvyhnfbzopzlbmeebvcocpgvzrwxshreerotwpsmgtyjienjbrzggfbiyafqjyxopljmceyjzysheisgzrmiznqxpvqzunpjyavaewleuenzogfnztvyilyyjoxdbmobmmdtipzevmdjskwudusmhqmqgjvhxmklyogidfmassjmehgkdzylrkbytzhslsfjgmtlrhljbwwgfcqjdquxaxvvwenjwsucenpyxchyyfeekwppmjmoijjhoyqkrlpxaexxhhwhmcnybcopnaewkpdyovkhizgjgeiplgwzjkymoobcqhaaxfalanujmauseehrlgtwsrighlkxtkaqpcdspxdczzwgdgxqmqmgjwmqkxqdjqvbuatkzwoyxkeascrgufmgezwoyotjgokbqflpdznalsbgwumsbzyhyxvylqhseutwzgldhzfutgapcnhgminmfjmqbvkgpferlqwupbpikrzoeiusqigvtsouoycfehwrxsmowdyguzubhptaza"));


        Assert.assertTrue(solution.containsNearbyDuplicate(new int[]{1,2,3,1},3));
        Assert.assertFalse(solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }

}
