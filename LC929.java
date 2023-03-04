// 929. Unique Email Addresses

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet();
        for (String mail : emails) {
            set.add(getMail(mail));
        }

        return set.size();
    }

    public String getMail(String mail) {
        String localname = mail.substring(0, mail.indexOf("@"));
        int index = localname.indexOf("+");
        if (index != -1)
            localname = localname.substring(0, index);
        index = localname.indexOf(".");
        if (index != -1)
            localname = localname.replaceAll("\\.", "");
        return localname + mail.substring(mail.indexOf("@"), mail.length());
    }
}