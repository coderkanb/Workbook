package com.kb.workbook.activity.mall;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.kb.workbook.R;
import com.kb.workbook.utils.LogUtils;

public class ContactsActivity extends AppCompatActivity {

    private static final java.lang.String TAG = ContactsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        printContacts();

    }

    private void printContacts() {

        //生成ContentResolver对象
        ContentResolver contentResolver = getContentResolver();

        Cursor cursor = contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

//        //这段代码和上面代码是等价的，使用两种方式获得联系人的Uri
//        Cursor cursor = contentResolver.query(Uri.parse("content://com.android.contacts/contacts"), null, null, null, null);

        int idColumn = cursor.getColumnIndex(ContactsContract.Contacts._ID);
        int displayNameColumn = cursor
                .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);

        // 获得联系人的ID
        String contactId = cursor.getString(idColumn);
        // 获得联系人姓名
        String displayName = cursor.getString(displayNameColumn);

        // 查看联系人有多少个号码，如果没有号码，返回0
        int phoneCount = cursor
                .getInt(cursor
                        .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

        if (phoneCount > 0) {

            // 获得联系人的电话号码列表
            Cursor phoneCursor = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                            + "=" + contactId, null, null);

            if (phoneCursor.moveToFirst()) {
                do {
                    //遍历所有的联系人下面所有的电话号码
                    String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    //使用Toast技术显示获得的号码
                    Toast.makeText(ContactsActivity.this, "联系人电话：" + phoneNumber, Toast.LENGTH_LONG).show();
                    LogUtils.d(TAG, "联系人电话：" + phoneNumber);
                } while (phoneCursor.moveToNext());
            }

        }

    }
}
