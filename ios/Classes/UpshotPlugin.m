#import "UpshotPlugin.h"
#if __has_include(<upshot_plugin/upshot_plugin-Swift.h>)
#import <upshot_plugin/upshot_plugin-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "upshot_plugin-Swift.h"
#endif

@implementation UpshotPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftUpshotPlugin registerWithRegistrar:registrar];
}
@end
